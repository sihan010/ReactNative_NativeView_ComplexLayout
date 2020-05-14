import React from 'react';
import {requireNativeComponent} from 'react-native';

const RCTCustomView = requireNativeComponent(
  'RCTMyCustomView',
  MyCustomView,
  {},
);

export default class MyCustomView extends React.PureComponent {
  _onClick = event => {
    if (!this.props.onClick) {
      return;
    }
    this.props.onClick(event.nativeEvent);
  };

  _onTextClick = event => {
    if (!this.props.onTextClick) {
      return;
    }
    this.props.onTextClick(event.nativeEvent);
  };

  render() {
    return (
      <RCTCustomView
        {...this.props}
        onClick={this._onClick}
        onTextClick={this._onTextClick}
      />
    );
  }
}
