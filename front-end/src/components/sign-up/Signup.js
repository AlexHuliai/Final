import React, { Component } from 'react';
import Axios from 'axios';
class Signup extends Component {
    state ={
        user :{
            firstName:'',
            lastName:'',
            age:'',
            email:'',
            telephone:'',
            password:'',
            zipcode:''
            

        }
    }
    submitHandler =(event) =>{
        event.preventDefault();
        console.log(this.state.user);
        Axios.post('http://localhost:8080/submitUserDetails', this.state.user)
        .then(response =>{
          this.props.history.push('/thank-you');

        }).catch(error =>{

        }
        )
        console.log(this.state.user);

    }

    handleChange =(event) =>{
            const value = event.target.value;
            const name = event.target.name;
            const tempUser = {...this.state.user};
            tempUser[name] = value;
            this.setState({
            user:tempUser
            })
    }
    render() {
        return (
            <div>
                <form onSubmit ={this.submitHandler} className="sign-up-form container">
                    <h2>Sign Up Here:</h2>
  <div className="row mb-1">
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.user.firstName} name="firstName" className="form-control" placeholder="First Name"/>
    </div>
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.user.lastName}  name="lastName" className="form-control" placeholder="Last Name"/>
    </div>
  </div>
  <div className="row mb-1">
  <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.user.age}  name="age" className="form-control" placeholder="Age"/>
    </div>
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.user.telephone}  name="telephone" className="form-control" placeholder="Telephone"/>
    </div>
    </div>
    <div className="row mb-1">
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.user.email}  name="email" className="form-control" placeholder="Email"/>
    </div>
    <div className="col">
      <input type="password" onChange={this.handleChange} value={this.state.user.password}  name="password" className="form-control" placeholder="Password"/>
    </div>
    <div className="col">
      <input type="text" onChange={this.handleChange} value={this.state.user.zipcode}  name="zipcode" className="form-control" placeholder="ZipCode"/>
    </div>
    
    </div>
    <button type="submit" className="btn btn-success btn btn-primary btn-lg btn-block ">Sign Up</button>
</form>
 </div>
        );
    }
}

export default Signup;