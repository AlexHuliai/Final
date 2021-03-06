import React, { Component } from 'react';

import Header from '../header/Header';
import Signup from '../sign-up/Signup';
import Thankyou from '../ThankYou/Thankyou';
import Aboutus from '../AboutUs/Aboutus';
import {Route, withRouter} from 'react-router-dom';
import Home from '../Home/Home';
import Maps from '../Maps/Maps';
import Event from '../Event/Event';


class Layout extends Component {
    render() {
        let routes = (
            <React.Fragment>
                <Route exact path="/" component={Signup} />
                <Route path="/sign-up" component={Signup}/>
                <Route path="/thank-you" component={Thankyou}/>
                
                {/* <Route component={Map}/> */}
            </React.Fragment>
        );
        if(localStorage.getItem("loggedInUser")){
                routes = (
                    <React.Fragment>
                             <Route path="/home" component={Home}/>
                             <Route exact path="/" component={Home}/>
                             <Route  component={Event}/>
                             
                             
                            
                             
                    </React.Fragment>
                )
        }
        return (
            <div>
                <Header {...this.props}/>
                {routes}
                <Route path="/about-us" component={Aboutus}/>
         
                <Maps/>
                 
                
               
                
                
               
            </div>
        );
    }
}

Layout.propTypes = {

};

export default withRouter(Layout);