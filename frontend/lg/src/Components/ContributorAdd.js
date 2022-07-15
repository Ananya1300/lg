import React, { useState } from "react";
import { useNavigate } from "react-router";
import ContributorService from "../Services/ContributorService";

const ContributorAdd = () => {

    const navigate = useNavigate();

    const [course, setCourse] = useState({
        title: "",
        creator: "",
        description: "",
        estimatedTime: 0,
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setCourse({...course, [e.target.name]: value});
        console.log(course);
    };

    const handleChangeNumber = (e) => {
        const value = e.target.value;
        setCourse({...course, ["estimatedTime"]: parseInt(value)});
        console.log(course);
    };

    const add = () => {
        ContributorService.addCourse(course)
        .then(
            (response) => {
                console.log(response);
                navigate("/contributor/homepage");
            }
        )
        .catch(
            (error) => {
                console.log(error);
            }
        );
    };

    return (
        <div>
            <input type="text" name="title" placeholder="Course Title" onChange={(e)=>handleChange(e)}></input>
            <input type="text" name="creator" placeholder="Creator Name" onChange={(e)=>handleChange(e)}></input>
            <input type="text" name="description" placeholder="Description" onChange={(e)=>handleChange(e)}></input>
            <input type="number" name="estimatedtime" placeholder="Estimated Time" onChange={(e)=>handleChangeNumber(e)}></input>
            <button onClick={add}>Add Course</button>
        </div>
    );
};

export default ContributorAdd;