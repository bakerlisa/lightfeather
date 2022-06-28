import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import styled from '../css/Popup.module.scss'

const Popup = () => {
    const history = useHistory();
    const [supervisor, setSupervisor] = useState([]);
    const [form, setForm] = useState({
        emailOnly:false,
        phoneOnly:false,
        supervisor: 1
    })

    const lengths = {
        firstName: 3,
        lastName: 3,
        supervisor: 1,
        phoneNumber: 10
    }

    const [error,setError] = useState({
        firstName: false,
        lastName: false,
        supervisor: false
    })

    const [dbError,setDBError] = useState({ id:0 })
    const [errMessage, setErrMessage] = useState(" ")
    var errorSize = Object.keys(dbError).length;

    // email handeler
    function ValidateEmail(event) {
        setForm({...form,[event.target.name]:event.target.value})

        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(event.target.value)){
            setError({...error, email: true})
        }else{
            setError({...error, email: false})
        }
    }

    // input handeler
    const onChangeHandler = (event) => {
        setForm({...form,[event.target.name]: event.target.value})
        
        if(event.target.value.length >= lengths[event.target.name]){
            setError({...error,[event.target.name]:true})
        }else{
            setError({...error,[event.target.name]:false})
        }
    }
    
    // checkbox handeler
    const onCheckboxChange = (event) => {
        if(form[event.target.name] === true){
            setForm({...form,[event.target.name]:false})
        }else{
            setForm({...form,[event.target.name]:true})
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

    const onKeyPress = (event) => {
        // restricts the numbers        
        if(event.nativeEvent.charCode === 48 || event.nativeEvent.charCode === 49 || event.nativeEvent.charCode === 50 || event.nativeEvent.charCode === 51 || event.nativeEvent.charCode === 52 || event.nativeEvent.charCode === 53 || event.nativeEvent.charCode === 54 || event.nativeEvent.charCode === 55 || event.nativeEvent.charCode === 56 || event.nativeEvent.charCode === 57){

        }else{
            setForm({...form,[event.target.name]: [event.target.value] + event.nativeEvent.key})
        }
        
        if(event.target.value.length >= lengths[event.target.name]){
            setError({...error,[event.target.name]:true})
        }else{
            setError({...error,[event.target.name]:false})
        }
    }

    const onBlurHandler = (event) => {
        event.target.value = form[event.target.name]
    }

    // on sucesssful user creation
    const [message,setMessage] = useState("")
    const [user,setUser] = useState([])

    // on sumbit handler
    const onSubmitHandler = (event) =>{
        event.preventDefault();
        if(Object.values(error).every(item => item) ){
            axios.post(`http://localhost:8080/api/submit/${form}`).then(response=>{
                console.log(response)
                if(response.data.length <= 0){
                    setErrMessage("There has been an error in your submission")
                }else{
                    setUser(response.data.user[0])
                    setMessage("Thank You!")
                    console.log(form);
                }  
            })
            .catch(err => {
                console.log("err.message")
                setDBError(err.message)
            });
        }else{
            console.log('')
        }

        setMessage("Thank You!")
        console.log(form)
        
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
            <h3>Notification Form </h3>
            {
            message.length === 0 ? <form onSubmit={onSubmitHandler} method="post">
                <p className={styled.required}>* Required Fields</p>
                <div className={styled.errWrp}>
                    {
                        dbError.length > 0 ? dbError : ""
                    }
                </div>

                <div>
                    <label htmlFor="firstName">*First Name</label>
                    <input required type="text" name="firstName" placeholder="First Name" onKeyPress={onKeyPress} onBlur={onBlurHandler}/>
                    {
                        error.firstName  ? "" : <span className={styled.error}>Please enter a First Name. LETTERS ONLY</span>
                    }
                </div>

                <div>
                    <label htmlFor="lastName">*Last Name</label>
                    <input required type="text" name="lastName" placeholder="Last Name" onKeyPress={onKeyPress} onBlur={onBlurHandler} />
                    {
                        error.lastName ? "" : <span className={styled.error}>Please enter a Last Name. LETTERS ONLY</span>
                    }
                </div>

                <h4>How woud you prefer to be notified?</h4>
                <div className="flex">
                    <div className={styled.col_2}>
                        <div className={styled.chkbxwpr}>
                            <input type="checkbox" name="emailOnly" onChange={onCheckboxChange} />
                            <label htmlFor="email">Email</label>
                        </div>
                        <input type="email" name="email" placeholder="Email: example@email.com..."  onChange={ValidateEmail} />
                    </div>

                    <div className={styled.col_2}>
                        <div className={styled.chkbxwpr}>
                            <input type="checkbox" name="phoneOnly" onChange={onCheckboxChange} />
                            <label htmlFor="phoneNumber">Phone:</label>
                        </div>
                        <input type="tel" name="phoneNumber" placeholder="Phone Number..." onChange={onChangeHandler} />
                    </div>
                </div>

                <div>
                    <label htmlFor="supervisor">*Supervisor</label>
                    <select  name="supervisor" onChange={onChangeHandler} >
                        {supervisor.length === 0 ? "" : supervisor.map((item,i) => {
                            if(parseInt(item.jurisdiction) || parseInt(item.jurisdiction) === 0) {
                            }else{
                                return <option key={i} value={item.id}>{item.jurisdiction} - {item.lastName}, {item.firstName}</option>
                            }
                        })}
                    </select>
                    {
                        error.supervisor ? "" : <span className={styled.error}>Please select a supervisor</span>
                    }
                </div>
                {
                    Object.keys(error).every((item) => error[item]) ? <input type="submit" value="Submit" className={styled.submit} /> : <input type="submit" value="Submit" className={styled.disabled} disabled />
                }

            </form> : <p className={styled.message}>{message}</p> 
            }
        </div>
    )
}

export default Popup;