import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import PersonCard from "../views/PersonCard";

const Person = (props) => {
    const [person,setPerson] = useState({})
    const { id } = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8080/api/person/${id}`)
        .then(response=>{
            setPerson(response.data)
        })
    })

    return(
        <div className="container">
            <h2>Single Person</h2>
            <p>Testing Routes to make sure the basics of the backend are working!</p>
            <Link className="button" to="/people">All People</Link>

            <PersonCard fname={person.firstName} lname={person.lastName} supervisor={person.supervisor} />
        </div>
    )
}

export default Person;