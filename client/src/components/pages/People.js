import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import styled from '../css/People.module.scss'
import PersonCard from '../views/PersonCard'

const People = () => {
    const [people,setPeople] = useState([])
    useEffect(() => {
        axios.get('http://localhost:8080/api/people')
        .then(response=>{
            setPeople(response.data)
        })
    })

    return(
        <div className={styled.container}>
            <h1>People</h1>
            <Link to="/" className='button'>Home</Link>
            {
                people.length === 0 ? "" : people.map((item,i) => {
                    return <PersonCard key={i} fname={item.firstName} lname={item.lastName} id={item.id} supervisor={item.supervisor} />
                })
            }
        </div>
    )
}

export default People;