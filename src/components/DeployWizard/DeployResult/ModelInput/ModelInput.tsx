import * as React from 'react';
import Scrollbars, { positionValues } from 'react-custom-scrollbars';
import { bind } from 'decko';

import styles from './ModelInput.module.css';

interface ILocalState {
  shadowBottomOpacity: number;
  shadowTopOpacity: number;
}

class ModelInput extends React.PureComponent<{}, ILocalState> {
  public state: ILocalState = { shadowBottomOpacity: 0, shadowTopOpacity: 0 };

  public render() {
    return (
      <div className={styles.model_input}>
        <div className={styles.title}>How to use</div>
        <div style={{ position: 'relative' }}>
          <Scrollbars autoHeightMax="200px" autoHeight={true} onScrollFrame={this.handleScrollbarUpdate}>
            <div className={styles.fields}>
              <div className={styles.header}>Name</div>
              <div className={styles.header}>Type</div>
              <div className={styles.content}>Cell Name</div>
              <div className={styles.content}>Cell Type</div>
              <div className={styles.content}>Cell Name</div>
              <div className={styles.content}>Cell Type</div>
              <div className={styles.content}>Cell Name</div>
              <div className={styles.content}>Cell Type</div>
              <div className={styles.content}>Cell Name</div>
              <div className={styles.content}>Cell Type</div>
              <div className={styles.content}>Cell Name</div>
              <div className={styles.content}>Cell Type</div>
            </div>
            <div
              className={styles.shadowBottom}
              style={{
                opacity: this.state.shadowBottomOpacity,
                visibility: this.state.shadowBottomOpacity > 0 ? 'visible' : 'collapse'
              }}
            />
          </Scrollbars>
        </div>
      </div>
    );
  }

  @bind
  private handleScrollbarUpdate(values: positionValues) {
    const { scrollTop, scrollHeight, clientHeight } = values;
    const bottomScrollTop = scrollHeight - clientHeight;
    const shadowBottomOpacity1 = (1 / 20) * (bottomScrollTop - Math.max(scrollTop, bottomScrollTop - 20));
    this.setState({
      ...this.state,
      shadowBottomOpacity: shadowBottomOpacity1
    });
  }
}

export default ModelInput;
