import axios from "axios";

const USER_API_BASE_URL = "http://localhost:9004/apis/user";
const CONTRIBUTOR_API_BASE_URL = "http://localhost:9004/apic/contributor";
const ADMIN_API_BASE_URL = "http://localhost:9004/apia/admin";

class ContributorService {
    
    saveContributor(contributor) {
        return axios.post(CONTRIBUTOR_API_BASE_URL + "/register", contributor);
    }

    validateLogin(contributor) {
        return axios.post(CONTRIBUTOR_API_BASE_URL + "/login", contributor);
    }

    addCourse(course) {
        return axios.post(CONTRIBUTOR_API_BASE_URL + "/add", course);
    }

    getAllCourses() {
        // http://localhost:9004/apic/contributor/getAllCourses
        return axios.get(CONTRIBUTOR_API_BASE_URL + "/getAllCourses");
    }

    deleteCourse(id) {
        return axios.delete(CONTRIBUTOR_API_BASE_URL + "/delete/" + id);
    }
}

export default new ContributorService();