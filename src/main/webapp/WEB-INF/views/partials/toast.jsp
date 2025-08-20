<%
    String successMsg = (String) session.getAttribute("flash_success");
    String errorMsg = (String) session.getAttribute("flash_error");
    String warningMsg = (String) session.getAttribute("flash_warning");
    session.removeAttribute("flash_success");
    session.removeAttribute("flash_error");
    session.removeAttribute("flash_warning");
%>

<script>
    <% if (successMsg != null) { %>
        Swal.fire({
            icon: 'success',
            title: 'Success',
            text: '<%= successMsg %>',
            showConfirmButton: false,
            timer: 2000,
            theme: 'dark'
        });
    <% } %>

    <% if (errorMsg != null) { %>
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: '<%= errorMsg %>',
            showConfirmButton: true,
            theme: 'dark'
        });
    <% } %>

    <% if (warningMsg != null) { %>
        Swal.fire({
            icon: 'warning',
            title: 'Warning',
            text: '<%= warningMsg %>',
            showConfirmButton: true,
            theme: 'dark'
        });
    <% } %>
</script>
