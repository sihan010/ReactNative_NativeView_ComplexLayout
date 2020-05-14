import React, {Component} from 'react';
import {StyleSheet, Text, View} from 'react-native';

import CustomLoginUI from './CustomLoginUi';
import MyCustomView from './MyCustomView';

class App extends Component {
  state = {
    status: false,
  };

  onClick = event => {
    alert('Received params: ' + JSON.stringify(event));

    this.setState({status: !this.state.status});
  };

  onTextClick = event => {
    alert('Received params: ' + JSON.stringify(event));
  };

  onLoginClicked = event => {
    console.log(event);
    alert('Received params: ' + JSON.stringify(event.nativeEvent));
  };

  render() {
    return (
      <View style={styles.container}>
        {/* <MyCustomView
          status={this.state.status}
          onClick={this.onClick}
          onTextClick={this.onTextClick}
          fontSize={18}
          style={{width: '100%', height: '100%'}}
        /> */}
        <CustomLoginUI
          userId="sihan"
          onLoginClicked={this.onLoginClicked}
          style={{width: '100%', height: '100%'}}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
});

export default App;
