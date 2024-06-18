    function printUsers() {
        // Open a new window
        var printWindow = window.open('', '_blank');
        // Write the HTML content to the new window
        printWindow.document.write('<html><head><title>User List</title></head><body>');
        printWindow.document.write('<h1>User List</h1>');
        printWindow.document.write('<table class="table table-striped">');
        printWindow.document.write('<thead><tr><th scope="col">User ID</th><th scope="col">Firstname</th><th scope="col">Lastname</th><th scope="col">Username</th><th scope="col">Created Date</th><th scope="col">Modified Date</th></tr></thead>');
        printWindow.document.write('<tbody>');
        // Loop through each user row and add it to the new window's content
        Array.from(document.querySelectorAll('tbody tr')).forEach(function(row) {
            printWindow.document.write(row.outerHTML);
        });
        printWindow.document.write('</tbody></table></body></html>');
        // Close the document
        printWindow.document.close();
        // Print the new window
        printWindow.print();
    }