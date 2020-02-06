import React,{ Component } from 'react';
import { Form, Button, FormGroup, FormControl, ControlLabel,Card } from "react-bootstrap";



class Search extends Component {
    render() {
        return (
        <form className="form-signin">
                <h2 className="form-signin-heading"> Please sign in </h2>
                <label for="inputEmail" className="sr-only"> Email address</label>
                <input type="email" id="inputEmail" className="form-control" placeholder="Email address" required autofocus />
              
            </form>
        )
    }
}

export default Search;