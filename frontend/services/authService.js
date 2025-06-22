export const register = async (userData) => {
	const response = await fetch("http://localhost:8080/auth/register", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(userData),
	});

	return response.json();
};

export const login = async (userData) => {
	const response = await fetch("http://localhost:8080/auth/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(userData),
	});

	return response.json();
};
