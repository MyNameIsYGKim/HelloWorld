/**
 * todolist.js
 */

 class Todolist {
	 
	 notUse() {
		 fetch('AjaxTodolistList.do')
		 .then(resolve => resolve.json())
		 .then(json => {
			 console.log(json);
		 })
		 .catch(console.log);
	 }
	 
	 // 글 목록.
	 todolistList(callback){
		 $.ajax({
			url: 'AjaxTodolistList.do',
			success: function(data) {
				callback(data);
			}
	 	})
	 }
	 
	 // 글 입력
	 todolistInsert(param={todolistConetent, todolistDate}, callback, errorcall) {
		 $.ajax({
			 url: 'AjaxTodolistInsert.do',
			 data: param,
			 success: function(data) {
				 callback(data);
			 },
			 error: function(err) {
				 errorcall(err)
			 }
		 })
	 }
	 
 }