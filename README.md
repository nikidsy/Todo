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


°Criando mútiplas tarefas para o mesmo usuário

<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-08-52" src="https://github.com/user-attachments/assets/ca01b131-29fa-4485-8254-14ec5612fcfc" />
<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-10-11" src="https://github.com/user-attachments/assets/a4c8726a-c157-44a3-bd30-a7bc5bcc379c" />


°Listando tarefas para o mesmo usuário

<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-11-27" src="https://github.com/user-attachments/assets/565620b5-eaf8-4db7-a82a-35e4fed9425a" />


°Atualizando Tarefa

<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-13-01" src="https://github.com/user-attachments/assets/7d82c312-ce5b-43b1-8f2e-994c462bd768" />


°Deletando Tarefa

<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-13-43" src="https://github.com/user-attachments/assets/b804de68-9d61-4cd1-8410-7ae355ec9e51" />


°Erro para criar Tarefa à um Usuário inexistente

<img width="1920" height="977" alt="Captura de tela de 2026-02-11 09-16-22" src="https://github.com/user-attachments/assets/3c628748-96ac-4963-bf21-ae58f66a4460" />
