// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model;

import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.versioning.*;
import ai.verta.modeldb.versioning.blob.diff.*;
import ai.verta.modeldb.versioning.blob.diff.Function3;
import ai.verta.modeldb.versioning.blob.visitors.Visitor;
import java.util.*;
import java.util.function.Function;

public class PathDatasetComponentDiff implements ProtoType {
  public DiffStatusEnumDiffStatus Status;
  public PathDatasetComponentBlob A;
  public PathDatasetComponentBlob B;

  public PathDatasetComponentDiff() {
    this.Status = null;
    this.A = null;
    this.B = null;
  }

  public Boolean isEmpty() {
    if (this.Status != null) {
      return false;
    }
    if (this.A != null) {
      return false;
    }
    if (this.B != null) {
      return false;
    }
    return true;
  }

  // TODO: not consider order on lists
  public Boolean equals(PathDatasetComponentDiff other) {
    if (other == null) {
      return false;
    }
    {
      Function3<DiffStatusEnumDiffStatus, DiffStatusEnumDiffStatus, Boolean> f =
          (x, y) -> x.equals(y);
      if (this.Status != null || other.Status != null) {
        if (this.Status == null && other.Status != null) return false;
        if (this.Status != null && other.Status == null) return false;
        if (!f.apply(this.Status, other.Status)) return false;
      }
    }
    {
      Function3<PathDatasetComponentBlob, PathDatasetComponentBlob, Boolean> f =
          (x, y) -> x.equals(y);
      if (this.A != null || other.A != null) {
        if (this.A == null && other.A != null) return false;
        if (this.A != null && other.A == null) return false;
        if (!f.apply(this.A, other.A)) return false;
      }
    }
    {
      Function3<PathDatasetComponentBlob, PathDatasetComponentBlob, Boolean> f =
          (x, y) -> x.equals(y);
      if (this.B != null || other.B != null) {
        if (this.B == null && other.B != null) return false;
        if (this.B != null && other.B == null) return false;
        if (!f.apply(this.B, other.B)) return false;
      }
    }
    return true;
  }

  public PathDatasetComponentDiff setStatus(DiffStatusEnumDiffStatus value) {
    this.Status = value;
    return this;
  }

  public PathDatasetComponentDiff setA(PathDatasetComponentBlob value) {
    this.A = value;
    return this;
  }

  public PathDatasetComponentDiff setB(PathDatasetComponentBlob value) {
    this.B = value;
    return this;
  }

  public static PathDatasetComponentDiff fromProto(
      ai.verta.modeldb.versioning.PathDatasetComponentDiff blob) {
    if (blob == null) {
      return null;
    }

    PathDatasetComponentDiff obj = new PathDatasetComponentDiff();
    {
      Function<ai.verta.modeldb.versioning.PathDatasetComponentDiff, DiffStatusEnumDiffStatus> f =
          x -> DiffStatusEnumDiffStatus.fromProto(blob.getStatus());
      obj.Status = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.PathDatasetComponentDiff, PathDatasetComponentBlob> f =
          x -> PathDatasetComponentBlob.fromProto(blob.getA());
      obj.A = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.PathDatasetComponentDiff, PathDatasetComponentBlob> f =
          x -> PathDatasetComponentBlob.fromProto(blob.getB());
      obj.B = Utils.removeEmpty(f.apply(blob));
    }
    return obj;
  }

  public ai.verta.modeldb.versioning.PathDatasetComponentDiff.Builder toProto() {
    ai.verta.modeldb.versioning.PathDatasetComponentDiff.Builder builder =
        ai.verta.modeldb.versioning.PathDatasetComponentDiff.newBuilder();
    {
      if (this.Status != null) {
        Function<ai.verta.modeldb.versioning.PathDatasetComponentDiff.Builder, Void> f =
            x -> {
              builder.setStatus(this.Status.toProto());
              return null;
            };
        f.apply(builder);
      }
    }
    {
      if (this.A != null) {
        Function<ai.verta.modeldb.versioning.PathDatasetComponentDiff.Builder, Void> f =
            x -> {
              builder.setA(this.A.toProto());
              return null;
            };
        f.apply(builder);
      }
    }
    {
      if (this.B != null) {
        Function<ai.verta.modeldb.versioning.PathDatasetComponentDiff.Builder, Void> f =
            x -> {
              builder.setB(this.B.toProto());
              return null;
            };
        f.apply(builder);
      }
    }
    return builder;
  }

  public void preVisitShallow(Visitor visitor) throws ModelDBException {
    visitor.preVisitPathDatasetComponentDiff(this);
  }

  public void preVisitDeep(Visitor visitor) throws ModelDBException {
    this.preVisitShallow(visitor);
    visitor.preVisitDeepDiffStatusEnumDiffStatus(this.Status);
    visitor.preVisitDeepPathDatasetComponentBlob(this.A);
    visitor.preVisitDeepPathDatasetComponentBlob(this.B);
  }

  public PathDatasetComponentDiff postVisitShallow(Visitor visitor) throws ModelDBException {
    return visitor.postVisitPathDatasetComponentDiff(this);
  }

  public PathDatasetComponentDiff postVisitDeep(Visitor visitor) throws ModelDBException {
    this.Status = visitor.postVisitDeepDiffStatusEnumDiffStatus(this.Status);
    this.A = visitor.postVisitDeepPathDatasetComponentBlob(this.A);
    this.B = visitor.postVisitDeepPathDatasetComponentBlob(this.B);
    return this.postVisitShallow(visitor);
  }
}