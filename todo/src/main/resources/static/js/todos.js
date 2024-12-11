document.addEventListener('DOMContentLoaded', () => {
    // 수정 버튼 클릭 이벤트
    document.querySelectorAll('.edit-todo').forEach(button => {
        button.addEventListener('click', function () {
            const todoItem = this.closest('li');
            const todoId = todoItem.dataset.id;
            const titleElement = todoItem.querySelector('.editable-title');
            const descriptionElement = todoItem.querySelector('.editable-description');
            
            // 텍스트를 수정 가능한 상태로 변경
            titleElement.contentEditable = true;
            descriptionElement.contentEditable = true;

            // 수정 버튼을 저장 버튼으로 변경
            this.textContent = '저장';
            this.classList.remove('edit-todo');
            this.classList.add('save-todo');
        });
    });

    // 저장 버튼 클릭 이벤트
    document.querySelectorAll('.save-todo').forEach(button => {
        button.addEventListener('click', function () {
            const todoItem = this.closest('li');
            const todoId = todoItem.dataset.id;
            const title = todoItem.querySelector('.editable-title').innerText;
            const description = todoItem.querySelector('.editable-description').innerText;

            // 서버에 수정된 내용 전송
            fetch(`/api/todos/${todoId}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ title: title, description: description })
            })
            .then(response => {
                if (!response.ok) throw new Error('Failed to update todo');
                // 서버에서 수정된 내용을 반영했다면
                const titleElement = todoItem.querySelector('.editable-title');
                const descriptionElement = todoItem.querySelector('.editable-description');
                titleElement.contentEditable = false;
                descriptionElement.contentEditable = false;

                // 버튼을 다시 수정 버튼으로 변경
                this.textContent = '수정';
                this.classList.remove('save-todo');
                this.classList.add('edit-todo');
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    });

    // 삭제 버튼 클릭 이벤트
    document.querySelectorAll('.delete-todo').forEach(button => {
        button.addEventListener('click', function () {
            const todoItem = this.closest('li');
            const todoId = todoItem.dataset.id;

            // 서버에서 삭제 요청
            fetch(`/api/todos/${todoId}`, {
                method: 'DELETE',
            })
            .then(response => {
                if (!response.ok) throw new Error('Failed to delete todo');
                // 삭제 성공 시 UI에서 항목 제거
                todoItem.remove();
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    });
});
