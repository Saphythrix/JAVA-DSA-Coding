# Write your MySQL query statement below
Select e.name,u.unique_id
from Employees e
Left join EmployeeUNI u on e.id=u.id