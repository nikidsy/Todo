TODO-LIST/RELACIONAMENTO 1:N

API REST desenvolvida com Spring Boot + JPA para gerenciar Usuários e Tarefas.

------

OBJETIVO

Implementar o relacionamento Um pra muitos:
°Um usuário pode ter varias tarefas
°Uma tarefa pertence a apenas um usuário
°Não pode existir tarefa sem usuário

------

IMPLEMENTAÇÃO DO RELACIONAMENTO

Usuário

@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
private List<Tarefa> tarefas = new ArrayList<>();


Tarefa

@ManyToOne(name = "usuario_id")
private Usuario usuario;

------

ENDPOINTS

°POST /usuario/{id}/tarefas

°GET /usuarios/{id}/tarefas

°PUT /tarefas/{id}

°DELETE /tarefas/{id}

------

TESTES (POSTMAN)

°Criando Usuário

<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-07-21" src="https://github.com/user-attachments/assets/b246a4e9-91f5-4d5c-83b0-1368343dd7fa" />

