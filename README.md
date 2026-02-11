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
° POST /usuario/{id}/tarefas
° GET /usuarios/{id}/tarefas
° PUT /tarefas/{id}
° DELETE /tarefas/{id}
