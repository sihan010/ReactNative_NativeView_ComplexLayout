import React from 'react';
import {requireNativeComponent} from 'react-native';

const RCTCustomLoginUI = requireNativeComponent(
  'CustomLoginUI',
  CustomLoginUI,
  {},
);

export default class CustomLoginUI extends React.PureComponent {
  _onLoginClicked = event => {
    if (!this.props.onLoginClicked) {
      return;
    }
    this.props.onLoginClicked(event.nativeEvent);
  };

  render() {
    return <RCTCustomLoginUI {...this.props} />;
  }
}
