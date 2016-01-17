var v = new Vue({
    el: 'body',
    data: {
        todos: [],
        todo: {
            'title': '',
            'done': false
        }
    },
    ready: function() {
        $.ajax('/todo', {
            method: 'get',
            context: this,
            success: function(response) {
                this.$set('todos', response);
            }
        });
    },
    methods: {
        add: function() {
            $.ajax('/todo', {
                method: 'post',
                context: this,
                contentType: 'application/json',
                data: JSON.stringify(this.todo),
                success: function(response) {
                    this.todos.push(response);
                    this.todo.title = '';
                }
            });
        },
        toggle: function(todo) {
            todo.done = !todo.done;

            $.ajax('/todo', {
                method: 'put',
                contentType: 'application/json',
                data: JSON.stringify(todo)
            });
        },
        remove: function(todo) {
            $.ajax('/todo/' + todo.id, {
                method: 'delete',
                context: this,
                success: function() {
                    this.todos.$remove(todo);
                }
            });
        }
    }
});