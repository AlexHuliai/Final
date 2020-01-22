import React, { Component } from 'react';
import Axios from 'axios';
class Event extends Component {
    state ={
        events :{
            street:'',
            state:'',
            date:'',
            zipcode:'',
    
        }
    }
    submitHandler =(event) =>{
        event.preventDefault();
       
        Axios.post('http://localhost:8080/submitEventDetails', this.state.events)
        .then(response =>{
          this.props.history.push('/thank-you');
        
        

    }).catch(error =>{

    }
    )
    console.log(this.state.events);
  }
    handleChange =(event) =>{
        const value = event.target.value;
        const name = event.target.name;
        const tempEvents = {...this.state.events};
        tempEvents[name] = value;
        this.setState({
        events:tempEvents
        })
}

   
    render() {
        return (
           
                <form onSubmit ={this.submitHandler} className="sign-up-form container">
                    <h2>Submit event here:</h2>
  <div className="row mb-1">
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.events.state} name="state" className="form-control" placeholder="State"/>
    </div>
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.events.street}  name="street" className="form-control" placeholder="Street"/>
    </div>
  </div>
  <div className="row mb-1">
  <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.events.date}  name="date" className="form-control" placeholder="Date"/>
    </div>
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.events.zipcode}  name="zipcode" className="form-control" placeholder="Zipcode"/>
    </div>
    </div>
    <button type="submit" className="btn btn-success btn btn-primary btn-lg btn-block ">Submit</button>
</form>
 
        );
    }
}   

export default Event;