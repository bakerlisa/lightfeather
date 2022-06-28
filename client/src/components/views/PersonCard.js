import axios from 'axios';
import React, { useEffect, useState } from 'react'
import styled from "../css/PersonCard.module.scss"

const PersonCard = (props) => {
    const [supervisors, setSupervisors] = useState([])

    useEffect(() => {
        axios.get('https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers')
        .then(response=>{
            setSupervisors(response.data)
        })
    })

    return(
        <div className="personCard">
            <h2>{props.fname} {props.lname}</h2>
            {
                supervisors.map((sup,i) => {
                    if(sup.id === props.supervisor){
                        return <>  <p className={styled.just}>{sup.jurisdiction} - {sup.lastName}, {sup.firstName} </p> <p className={styled.phone}>{sup.phone}</p></>
                    }
                })
            }
        </div>
    )
}

export default PersonCard;