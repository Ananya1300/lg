import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import UserService from "../Services/UserService";

const UserCourses = () => {
    const navigate = useNavigate();
    
    const [courses, setCourses] = useState(null);
    const [loading, setLoading] = useState(true);
    const [enrolledCourses, setEnrolledCoures] = useState(null);

    useEffect(() => {
        let user = localStorage.getItem("user");
        if(user === null) {
            navigate("/user/login");
        }
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await UserService.getCourses();
                setCourses(response.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        };
        fetchData();
    }, []);

    const logout = (e) => {
        localStorage.removeItem("user");
        navigate("/user/login");
    };
    const about = (e) => {
        navigate("/user/about");
    };
    const dashboard = (e) => {
        navigate("/user/homepage");
    };
    const enroll = (e, id) => {
        e.preventDefault();
        UserService.enrollCourse(id)
        .then(
            (response) => {
                setEnrolledCoures(response.data);
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
            <nav>
                <h2>Learners Guide</h2>
                <button onClick={(e) => dashboard(e)}>Dashboard</button>
                <button onClick={(e) => about(e)}>About</button>
            </nav>
            <button onClick={(e) => logout(e)}>Logout</button>
            <table>
            {!loading && (
                <tbody>
                    {
                        courses.map(
                            (course) => (
                                <tr key={course.id}>
                                    <td>{course.id}</td>
                                    <td>{course.title}</td>
                                    <td>{course.description}</td>
                                    <td>{course.creator}</td>
                                    <td>{course.estimatedTime}</td>
                                    <td><button onClick={(e, id) => enroll(e, course.id)}>Enroll</button></td>
                                </tr>
                            )
                        )
                    }
                </tbody>
            )}
            </table>
        </div>
    );
};

export default UserCourses;