## 软件工程综合实践 图书馆里系统

图书表：（不同图书由图书编号区分，不再设置每本书的uuid）<br>
 图书编号（主键）<br>
 图书名称<br>
 出版社<br>
 作者<br>
 出版日期<br>
 价格<br>
 入库日期<br>
 入库数量<br>
 现存数量<br>
 （移除了删除位 暂时不提供下架功能）

用户表：<br>
 用户编号(int)（主键）<br>
 用户名<br>
 密码<br>
 用户姓名<br>
 性别<br>
 电话<br>
 用户状态（状态：0正常，1封禁）<br>
 用户权限（用户权限：0读者 1管理员）<br>
 （移除了密保问题）

用户借阅历史表：（不包含正在借阅的记录）<br>
 任务序号（主键）<br>
 借阅书号<br>
 借阅人编号<br>
 借阅日期<br>
 应还日期<br>
 实际还书日期<br>
 罚款金额<br>
 
 用户借阅表：（记录正在外借的书目信息）<br>
 任务序号（主键）<br>
  借阅书号<br>
  借阅人编号<br>
  借阅日期<br>
  应还日期<br>
  

2020/7/3新增功能：<br>
1.用户登录(使用已有账号进行登录，登录后根据权限不同，开放不同的功能)<br>
2.读者注册（进行读者账户的注册）<br>
3.忘记密码（通过读者账号进行手机验证进行密码重置）<br>
4.管理员管理/图书管理/图书编辑（可以对图书进行信息的编辑*仅对管理员账户开放）<br>
5.管理员管理/图书管理/添加书籍（可以进行图书的添加*仅对管理员账户开放）<br>
完善中……