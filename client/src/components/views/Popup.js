import React, { useEffect, useState } from 'react';
import styled from '../css/Popup.module.scss'
import axios from 'axios';

const Popup = () => {
    axios.get('https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers').then(response=>{
        console.log(response);
    })
    return (
        <div className={styled.popWrp}>
            <h3>Notification Form</h3>
            <form>
                <p className={styled.required}>* Required Fields</p>

                <div>
                    <label htmlFor="fname">*First Name</label>
                    <input type="text" name="fname" id="" placeholder="First Name" />
                </div>

                <div>
                    <label htmlFor="lname">*Last Name</label>
                    <input type="text" name="lname" id="" placeholder="Last Name" />
                </div>

                <h4>How woud you prefer to be notified?</h4>
                <div className="flex">
                    <div className={styled.col_2}>
                        <div>
                            <input type="checkbox" name="econtact" id="" />
                            <label htmlFor="email">*Email</label>
                        </div>
                        <input type="email" name="email" id="" placeholder="Email: example@email.com..."/>
                    </div>

                    <div className={styled.col_2}>
                        <div>
                            <input type="checkbox" name="tcontact" id="" />
                            <label htmlFor="number">Phone:</label>
                        </div>
                        <input type="tel" name="number" id="" placeholder="Phone Number..." />
                    </div>
                </div>

                <div>
                    <label htmlFor="supervisor">*Supervisor</label>
                    <select name="supervisor" id="" defaultValue="default">
                        <option value="default" disabled >Select...</option>
                    </select>
                </div>

                <input type="submit" value="Submit" className={styled.submit} />
            </form>
        </div>
    )
}

export default Popup;