import axios from "axios";

const USER_API_BASE_URL = "http://localhost:9004/apis/user";
const CONTRIBUTOR_API_BASE_URL = "http://localhost:9004/apic/contributor";
const ADMIN_API_BASE_URL = "http://localhost:9004/apia/admin";

class UserService {
  saveUser(user) {
    return axios.post(USER_API_BASE_URL + "/register", user);
  }

  validateLogin(user) {
    return axios.post(USER_API_BASE_URL + "/login", user);
  }

  getCourses() {
    return axios.get(USER_API_BASE_URL + "/courses/all");
  }

  enrollCourse(id) {
    return axios.post(USER_API_BASE_URL + "/enroll/" + id);
  }
}

export default new UserService();
