import React,{ Component } from 'react';
import Header from './components/Header';
import Search from './components/Search';
import Content from './components/Content';
import 'whatwg-fetch';
import 'bootstrap/dist/css/bootstrap.css'
import { Form, Button, FormGroup, FormControl, ControlLabel } from "react-bootstrap";

class App extends Component {
  render(){
    return  (
        <div>
            <Header/>
            <Search/>
            
            <Content/><Content/>
            <Content/>
            <Content/>
            <Content/>

        </div>
    );
}
}


export default App;
