import axios from 'axios'
import React, { useEffect, useState } from 'react'
import styled from '../css/People.module.scss'

const People = () => {
    useEffect(() => {
        axios.get('http://localhost:8080/api/people')
        .then(response=>{
            console.log(response.data)
        })
    })

    return(
        <div className={styled.container}>
            <h1>People</h1>
        </div>
    )
}

export default People;