<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en" data-theme="sunset">

<%@ include file="../partials/header.jsp" %>

<body class="flex items-center justify-center min-h-screen bg-base-200">

    <div class="card w-96 bg-base-100 shadow-xl">
        <div class="card-body">
            <h2 class="card-title text-center text-2xl font-bold mb-4">Login</h2>

            <form action="<%= request.getContextPath() %>/login" method="post" class="space-y-4">
                <div class="form-control">
                    <label class="label" for="username">
                        <span class="label-text">Username</span>
                    </label>
                    <input type="text" id="username" name="username" placeholder="Enter username" class="input input-bordered" required />
                </div>

                <div class="form-control">
                    <label class="label" for="password">
                        <span class="label-text">Password</span>
                    </label>
                    <input type="password" id="password" name="password" placeholder="Enter password" class="input input-bordered" required />
                </div>

                <div class="form-control mt-6">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>

<%@ include file="../partials/toast.jsp" %>
</body>

</html>