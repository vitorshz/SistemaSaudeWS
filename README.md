# bosin sistema saude ws

# requisitos de funcionaidade

- [ ]  Deve ser possivel cadastrar um medico;
- [ ]  deve ser possivel listar os medicos cadastrados;
- [ ]  deve ser possivel atualizar um medico por id;
- [ ]  deve ser possivel desativar um medico do sistema;
- [ ]  deve ser possivel cadastrar um paciente;
- [ ]  deve ser possivel listar os pacientes cadastrados;
- [ ]  deve ser possivel atualizar um paciente;
- [ ]  deve ser possivel desativar um paciente do sistema;
- [ ]  deve ser possivel agendar uma consulta;
- [ ]  deve ser possivel cancelar uma consulta;

# regras de negocio

- [ ]  a listagem de médicos devem ser ordenada por ordem crescente pelo nome do medico;
- [ ]  não é permitido alterar o e-mail, crm e a especialidade do medico;
- [ ]  não é permitido alterar o e-mail e o cpf do paciente;
- [ ]  a listagem de paciente devem ser ordenada por ordem crescente pelo nome do paciente;
- [ ]  As consultas tem duração fixa de 1 hora;
- [ ]  As consultas devem ser agendadas com antecedência mínima de 30 minutos;
- [ ]  Não permitir o agendamento de consultas com pacientes inativos no sistema;
- [ ]  Não permitir o agendamento de consultas com médicos inativos no sistema;
- [ ]  Não permitir o agendamento de mais de uma consulta no mesmo dia para um mesmo paciente;
- [ ]  Não permitir o agendamento de uma consulta com um médico que já possui outra consulta agendada na mesma data/hora;
- [ ]  A escolha do médico é opcional, sendo que nesse caso o sistema deve escolher aleatoriamente algum médico disponível na data/hora preenchida.
- [ ]  O horário de funcionamento da clínica é de segunda a sábado, das 07:00 às 19:00;
- [ ]  É obrigatório informar o motivo do cancelamento da consulta, dentre as opções: paciente desistiu, médico cancelou ou outros;
- [ ]  Uma consulta somente poderá ser cancelada com antecedência mínima de 24 horas;
- [ ]  exclusão de dados: não deve apagar os dados, mas torná-lo inativo;
- [ ]  no cadastro de médico/paciente: todas informações deve ter preenchimento obrigatório, exceto número e complemento de endereço;

# requisitos não funcionais

- [ ]  deve ser ultilizado uma aplicação padrão jaxws;
- [ ]  deve ser persistido os dados em um banco de dados postgres;

# classes da aplicação

![Database ER diagram (crow's foot).png](bosin%20sistema%20saude%20ws%20e0e7b425704047a0b431b5475e18182d/Database_ER_diagram_(crows_foot).png)

### pessoa

- id : int;
- nome : string;
- email: string;
- telefone: string;
- pacienteid: int?;
- medicoid:int?;
- enderecoid:int?;

### medico

- id: int;
- crm:string;
- especializacao : [”Ortopedia”,”cardiologia”, ”ginecologia”, ”dermatologia”]
- pessoaid: int?;

# banco de dados

![Database ER diagram (crow's foot).png](bosin%20sistema%20saude%20ws%20e0e7b425704047a0b431b5475e18182d/Database_ER_diagram_(crows_foot)%201.png)
