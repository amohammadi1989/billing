<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
List size is ${sizeali}

<table class="tb-regist" id="eeMsg">
    <thead>
    <tr>
        <th>#</th>
        <th>NAME</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>Amount</th>
        <th>Interest</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${listAcc}" var="li">
    <tr>
        <td>${li.id}</td>
        <td>${li.name}</td>
        <td>${li.lastName}</td>
        <td>${li.age}</td>
        <td>${li.address}</td>
        <td>${li.amount}</td>
        <td>${li.newAmount}</td>
    </tr>
</c:forEach>
    </tbody>

</table>
</body>
</html>