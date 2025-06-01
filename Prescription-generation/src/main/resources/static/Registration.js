import React, { useState } from "react";
import axios from "axios";

const Register = () => {
    const [formData, setFormData] = useState({
        username: "",
        password: "",
        confirmPassword: ""
    });

    const [errors, setErrors] = useState({});
    const [successMessage, setSuccessMessage] = useState("");

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const validate = () => {
        let formErrors = {};
        if (!formData.username) formErrors.username = "Username is required";
        if (!formData.password) formErrors.password = "Password is required";
        if (formData.password !== formData.confirmPassword)
            formErrors.confirmPassword = "Passwords do not match";
        setErrors(formErrors);
        return Object.keys(formErrors).length === 0;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!validate()) return;

        try {
            const response = await axios.post("http://localhost:8080/api/auth/register", {
                username: formData.username,
                password: formData.password
            });
            setSuccessMessage("Registration successful! Please log in.");
            setFormData({ username: "", password: "", confirmPassword: "" });
            setErrors({});
        } catch (error) {
            setErrors({ apiError: error.response?.data?.message || "Registration failed." });
        }
    };

    return (
        <div className="max-w-md mx-auto bg-white shadow-lg rounded-lg p-8">
            <h2 className="text-2xl font-bold mb-6 text-center">Register</h2>
            {successMessage && (
                <div className="bg-green-100 text-green-700 px-4 py-2 rounded mb-4">
                    {successMessage}
                </div>
            )}
            {errors.apiError && (
                <div className="bg-red-100 text-red-700 px-4 py-2 rounded mb-4">
                    {errors.apiError}
                </div>
            )}
            <form onSubmit={handleSubmit}>
                <div className="mb-4">
                    <label className="block text-gray-700 font-medium mb-2">Username</label>
                    <input
                        type="text"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                        className={`w-full px-3 py-2 border ${
                            errors.username ? "border-red-500" : "border-gray-300"
                        } rounded`}
                    />
                    {errors.username && (
                        <p className="text-red-500 text-sm mt-1">{errors.username}</p>
                    )}
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 font-medium mb-2">Password</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        className={`w-full px-3 py-2 border ${
                            errors.password ? "border-red-500" : "border-gray-300"
                        } rounded`}
                    />
                    {errors.password && (
                        <p className="text-red-500 text-sm mt-1">{errors.password}</p>
                    )}
                </div>
                <div className="mb-6">
                    <label className="block text-gray-700 font-medium mb-2">Confirm Password</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                        className={`w-full px-3 py-2 border ${
                            errors.confirmPassword ? "border-red-500" : "border-gray-300"
                        } rounded`}
                    />
                    {errors.confirmPassword && (
                        <p className="text-red-500 text-sm mt-1">{errors.confirmPassword}</p>
                    )}
                </div>
                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition-colors"
                >
                    Register
                </button>
            </form>
        </div>
    );
};

export default Register;
