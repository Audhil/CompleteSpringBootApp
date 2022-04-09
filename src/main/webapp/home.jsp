<html>
<head><title>First JSP</title></head>
<body>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>

<h2>Add Alien</h2>
  <form action="addAlien">
  <input type="text" name="aId"><br>
    <input type="text" name="aName"><br>
    <input type="text" name="tech"><br>
      <input type="submit"><br>
  </form>

<h2>Get Alien {Enter aId to getAlien}</h2>
  <form action="getAlien">
  <input type="text" name="aId"><br>
      <input type="submit"><br>
  </form>

<h2>Update Alien</h2>
  <form action="updateAlien">
  <input type="text" name="aId"><br>
    <input type="text" name="aName"><br>
    <input type="text" name="tech"><br>
      <input type="submit"><br>
  </form>

  <h2>Delete Alien {Enter aId to deleteAlien}</h2>
    <form action="deleteAlien">
    <input type="text" name="aId"><br>
        <input type="submit"><br>
    </form>

    <h2>Get Alien by tech {Enter tech to getAlien}</h2>
        <form action="getByTech">
        <input type="text" name="tech"><br>
            <input type="submit"><br>
        </form>
</body>
</html>
