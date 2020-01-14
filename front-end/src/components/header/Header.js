import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import  Axios  from 'axios';

class Header extends Component {
    state = {
        user:{
            email:'',
            password:''
        }  
    }
    signOut = ()=>{
        localStorage.removeItem("loggedInUser");
        this.props.history.push("/");
    }
    handleChange = (event)=>{
        const value = event.target.value;
        const name = event.target.name;
        const tempUser = {...this.state.user};
        tempUser[name] = value;
        this.setState({
            user:tempUser
        })
    }
   submitHandler = (event)=>{
       event.preventDefault();
       Axios.post('http://localhost:8080/login',this.state.user)
       .then(response => {
           localStorage.setItem("loggedInUser", response.data.email);

           this.props.history.push("/home");
       }).catch(error =>{;

       })
   }

    render() {
        let links =(
         <li className="nav-item active">
            <Link className="nav-link" to="/sign-up">Sign Up <span className="sr-only">(current)</span></Link>
        </li>
        )
        let signInSignOutForm = (<form onSubmit={this.submitHandler} className="form-inline mt-2 mt-md-0">
        <input onChange={this.handleChange} defaultValue={this.state.email} name="email"className="form-control mr-sm-2" type="text" placeholder="email" aria-label="email" />
        <input onChange={this.handleChange} defaultValue={this.state.password} name="password" className="form-control mr-sm-2" type="password" placeholder="password" aria-label="password" />
        <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Sign In</button>
    </form>);
    if(localStorage.getItem("loggedInUser")){
        links =(
                             <li className="nav-item active">
                                <Link className="nav-link" to="/settings">Settings <span className="sr-only">(current)</span></Link>
                            </li>
        )
        signInSignOutForm =  <button onClick={this.signOut} className="btn btn-outline-success my-2 my-sm-0" type="submit">Sign Out</button>
    }
        return (
            <div className="margin-bottom-80px">
                <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                    <Link className="navbar-brand" to="/">Users Portal</Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav mr-auto">
                            {links}
                            <li className="nav-item">
                                <Link className="nav-link" to="about-us">About us</Link>
                            </li>
                            {/* <li className="nav-item">
                                <a className="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li> */}
                        </ul>
                        {signInSignOutForm}
                    </div>
                </nav>
            </div>
        );
    }
}

export default Header;