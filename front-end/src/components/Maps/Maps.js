import React, { Component } from 'react';
import { Map, GoogleApiWrapper, Marker } from 'google-maps-react';
import Geocode from "react-geocode";
class Maps extends Component {
  constructor(props) {
    super(props);

    this.state = {
      events: []
    }
  }
   
  displayMarkers = () => {
    return this.state.events.map((events, index) => {
      return <Marker key={index} id={index} position={{
       lat: events.latitude,
       lng: events.longitude
     }}
     onClick={() => '<h1>Hello</h1>'} />
    })
  }
  render() {
    return (
      <Map 
          google={this.props.google}
          zoom={11}
          style={mapStyles}
          initialCenter={{ lat: 38.6330954, lng: -90.1994}}>
          {this.displayMarkers()}
        </Map>
    );
  }
}
const mapStyles = {
  width: '100%',
  height: '100%',
};
export default GoogleApiWrapper({
  apiKey:'AIzaSyBlpDEM1hWvFmFHgWmTp6F1qRjLLIx9yi8'

})(Maps);