import React from 'react';
import {requireNativeComponent} from 'react-native';

const RCTCustomLoginUI = requireNativeComponent(
  'CustomLoginUI',
  CustomLoginUI,
  {},
);

export default class CustomLoginUI extends React.PureComponent {
  render() {
    return (
      <RCTCustomLoginUI
        {...this.props}
        style={styles.container}
        onLoginClicked={event => {
          this.props.onLoginClicked
            ? this.props.onLoginClicked(event.nativeEvent)
            : null;
        }}
        userId={this.props.userId ? this.props.userId : 'abc'} //If prop is provided then return that prop, else provide default value
      />
    );
  }
}

const styles = {
  container: {width: '100%', height: '100%'},
};
