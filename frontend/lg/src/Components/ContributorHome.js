import React, { Component } from "react";
import ContributorService from "../Services/ContributorService";
import ContributorHomeNav from "./ContributorHomeNav";

export default class ContributorHome extends Component {
    constructor(props) {
        super(props);
        this.state = {
            courses: []
        };
        // this.deleteCourse = this.deleteCourse.bind(this);
    }

    componentDidMount() {
        ContributorService.getAllCourses()
        .then(
            (response) => {
                console.log(response);
                this.setState({
                    courses: response.data
                })
            }
        )
    }

    // deleteCourse = (e, id) => {
    //     e.preventDefault();
    //     ContributorService.deleteCourse(id)
    //     .then(
    //         (response) => {
    //             if(this.state.courses) {
    //                 this.setState({
    //                     courses: response.filter((course) => course.id !== id)
    //                 })
    //             }
    //         }
    //     )
    //     .catch(
    //         (error) => {
    //             console.log(error);
    //         }
    //     );
    // }

    render() {
        const {courses} = this.state
        return(
            <div>
                <ContributorHomeNav />
                <table>
                    <tbody>
                        {
                            courses.map(
                                function(course) {
                                    return( <tr key={course.id}>
                                                <td>{course.id}</td>
                                                <td>{course.title}</td>
                                                <td>{course.description}</td>
                                                <td>{course.creator}</td>
                                                <td>{course.estimatedTime}</td>
                                                {/* <td><button onClick={this.deleteCourse(course.id)}>delete</button></td> */}
                                            </tr>
                                    )
                                }
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}