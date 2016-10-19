package edu.mit.csail.db.ml.modeldb.client.event

import com.twitter.util.Await
import edu.mit.csail.db.ml.modeldb.client._
import modeldb.ModelDBService.FutureIface
import org.apache.spark.ml
import org.apache.spark.ml.{PipelineStage, SyncableEstimator, Transformer}
import org.apache.spark.sql.DataFrame

/**
  * Event indicating that an Estimator was used to fit a model.
  *
  * @param estimator - The estimator performing the fitting.
  *                  It's a pipeline stage because we can't easily
  *                  type parameterize all Estimators.
  * @param dataframe - The data being fit.
  * @param model - The model produced by the fitting procedure.
  */
case class FitEvent(estimator: PipelineStage,
                    dataframe: DataFrame,
                    model: Transformer) extends ModelDbEvent {

  def makeEvent(mdbs: ModelDbSyncer) = modeldb.FitEvent(
    SyncableDataFrame(dataframe),
    SyncableEstimator(dataframe, estimator),
    SyncableTransformer(model),
    mdbs.getFeaturesForDf(dataframe).getOrElse(ml.SyncableEstimator.getFeatureCols(estimator)),
    ml.SyncableEstimator.getPredictionCols(estimator),
    ml.SyncableEstimator.getLabelColumns(estimator),
    mdbs.project.id,
    experimentRunId = mdbs.experimentRun.id,
    problemType = SyncableProblemType(model)
  )

  def associate(fer: modeldb.FitEventResponse, mdbs: ModelDbSyncer) = {
    mdbs.associateObjectAndId(dataframe, fer.dfId)
      .associateObjectAndId(estimator, fer.specId)
      .associateObjectAndId(model, fer.modelId)
      .associateObjectAndId(this, fer.eventId)
  }
  override def sync(client: FutureIface, mdbs: Option[ModelDbSyncer]): Unit = {
    val res = Await.result(client.storeFitEvent(makeEvent(mdbs.get)))
    SyncableLinearModel(model) match {
      case Some(lm) => Await.result(client.storeLinearModel(res.modelId, lm))
      case None => {}
    }
    associate(res, mdbs.get)
  }
}