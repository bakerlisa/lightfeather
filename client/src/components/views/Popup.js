import React, { useEffect, useState, useSyncExternalStore } from 'react';
import { useHistory } from 'react-router-dom';
import styled from '../css/Popup.module.scss'
import axios from 'axios';

const Popup = () => {
    const history = useHistory();

    const [supervisor, setSupervisor] = useState([]);
    const [form, setForm] = useSyncExternalStore({})

    const lengths = {
        firstName: 3,
        lastName: 3,
        phoneNumber: 10
    }

    const [error,setError] = useState({
        firstName: false,
        lastName: false,
        phoneNumber: false
    })

    const [dbError,setDBError] = useState({ id:0 })
    const [errMessage, setErrMessage] = useState(" ")
    var errorSize = Object.keys(dbError).length;

    function ValidateEmail(event) {
        setForm({...form,[event.target.name]:event.target.value})

        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(event.target.value)){
            setError({...error, email: true})
        }else{
            setError({...error, email: false})
        }
    }

    const onChangeHandler = (event) => {
        setForm({...form,[event.target.name]: event.target.value})

        if(event.target.name in error){
            if(event.target.value.length >= lengths[event.target.name]){
                setError({...error,[event.target.name]:true})
            }else{
                setError({...error,[event.target.name]:false})
            }
        }
    }

    // sorts supervisors
    const handleSort = (data) =>{
        setSupervisor(data
            .sort((a,b) => {
                if(a.jurisdiction === b.jurisdiction){
                    if(a.lastName === b.lastName){
                        // if first names match sort by first name
                        return a.firstName > b.firstName ? 1: -1
                    }else{
                        // last names match sort by last names
                        return a.lastName > b.lastName ? 1: -1
                    }
                }
                // if jurisdiction's match sort by jurisdiction
                return a.jurisdiction > b.jurisdiction ? 1: -1
            })
        )
    }

    useEffect(() => {
        axios.get('https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers')
        .then(response=>{
            setSupervisor(response.data)
            handleSort(response.data)
        })
    })
    return (
        <div className={styled.popWrp}>
            <h3>Notification Form</h3>
            <form>
                <p className={styled.required}>* Required Fields</p>

                <div>
                    <label htmlFor="firstName">*First Name</label>
                    <input type="text" name="firstName" placeholder="First Name" />
                </div>

                <div>
                    <label htmlFor="lastName">*Last Name</label>
                    <input type="text" name="lastName" placeholder="Last Name" />
                </div>

                <h4>How woud you prefer to be notified?</h4>
                <div className="flex">
                    <div className={styled.col_2}>
                        <div>
                            <input type="checkbox" name="econtact" />
                            <label htmlFor="email">*Email</label>
                        </div>
                        <input type="email" name="email" placeholder="Email: example@email.com..."  onChange={ValidateEmail} />
                    </div>

                    <div className={styled.col_2}>
                        <div>
                            <input type="checkbox" name="tcontact" />
                            <label htmlFor="phoneNumber">Phone:</label>
                        </div>
                        <input type="tel" name="phoneNumber" placeholder="Phone Number..." />
                    </div>
                </div>

                <div>
                    <label htmlFor="supervisor">*Supervisor</label>
                    <select name="supervisor" defaultValue="default">
                        <option value="default" disabled >Select...</option>
                        {supervisor.length === 0 ? "" : supervisor.map((item,i) => {
                            if(parseInt(item.jurisdiction) || parseInt(item.jurisdiction) === 0) {
                            }else{
                                return <option key={i} value={item.id}>{item.jurisdiction} - {item.lastName}, {item.firstName}</option>
                            }
                        })}
                    </select>
                </div>
                <input type="submit" value="Submit" className={styled.submit} />
            </form>
        </div>
    )
}

export default Popup;