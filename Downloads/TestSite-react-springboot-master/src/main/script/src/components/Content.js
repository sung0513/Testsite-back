import React,{ Component } from 'react';
import { Form, Button, FormGroup, FormControl, ControlLabel, Card } from "react-bootstrap";


class Content extends React.Component {
      render() {
        return (
          <Card style={{ width: '18rem' }}>
          <Card.Body>
            <Card.Title>치킨</Card.Title>
            <Card.Subtitle className="mb-2 text-muted">Card Subtitle</Card.Subtitle>
            <Card.Text>
            </Card.Text>
            <Card.Link href="#"></Card.Link>
            <Card.Link href="#">Another Link</Card.Link>
          </Card.Body>
        </Card>
        );
      }
    }

export default Content;