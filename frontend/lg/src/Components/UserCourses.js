import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import UserService from "../Services/UserService";

const UserCourses = () => {
    const navigate = useNavigate();
    
    const [courses, setCourses] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
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