import React from "react";
import AdminService from "../Services/AdminService";
import { useState,useEffect } from "react";

const AdminHome=()=>
{

    const [courses, setCourses] = useState(null);
    const [loading, setLoading] = useState(true);
    const[users,setUsers]=useState(null);
    

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await AdminService.getCourses();
                setCourses(response.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        };
        fetchData();

        const fetchData2=async()=>{
            setLoading(true);
            try{
                const response=await AdminService.getUsers();
                setUsers(response.data);
            }
            catch(error){
                console.log(error);
            }
            setLoading(false);
        };
        fetchData2();
    }, []);

    return(
        <div>
            <h3>Yes you are logged in</h3>
            <div>

            
            <table>
            {!loading && (
                <tbody>
                    {
                        courses.map(
                            (course) => (
                                <tr key={course.id}>
                                    <td>{course.id}</td>
                                    <td>{course.creator}</td>
                                    <td>{course.title}</td>
                
                                </tr>
                            )
                        )
                    }
                </tbody>
            )}
            </table>
            </div>
            <div>
            <table>
            {!loading && (
                <tbody>
                    {
                        users.map(
                            (user) => (
                                <tr key={user.username}>
                                    <td>{user.username}</td>
                                    
                
                                </tr>
                            )
                        )
                    }
                </tbody>
            )}
            </table>
            </div>
        </div>
    )
}
export default AdminHome;