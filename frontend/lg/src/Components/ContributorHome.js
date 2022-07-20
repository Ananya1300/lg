import React, { Component, useEffect, useState } from "react";
import { useNavigate } from "react-router";
import ContributorService from "../Services/ContributorService";
import ContributorHomeNav from "./ContributorHomeNav";

const ContributorHome = () => {
    const navigate = useNavigate();

    const [courses, setCourses] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        let contributor = localStorage.getItem("contributor");
        if(contributor === null) {
            navigate("/contributor/login");
        }

        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await ContributorService.getAllCourses();
                setCourses(response.data);
            } catch(error) {
                console.log(error);
            }
            setLoading(false);
        };
        fetchData();
    }, []);

    const deleteCourse = (e, id) => {
        e.preventDefault();
        ContributorService.deleteCourse(id)
        .then(
            (response) => {
                if(courses) {
                    setCourses((prevElement) => {
                        return prevElement.filter((course) => course.id !== id);
                    });
                }
            }
        );
    };

    return(
        <div>
            <ContributorHomeNav />
            <table>
                
                    {!loading && (
                        <tbody> 
                            {
                                courses.map(
                                    (course) => ( <tr key={course.id}>
                                        <td>{course.id}</td>
                                        <td>{course.title}</td>
                                        <td>{course.description}</td>
                                        <td>{course.creator}</td>
                                        <td>{course.estimatedTime}</td>
                                        <td><button onClick={(e, id) => deleteCourse(e, course.id)}>delete</button></td>
                                    </tr>)
                                )
                            }
                            </tbody>
                    )}
                
            </table>
        </div>
    )
};

export default ContributorHome;