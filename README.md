# bosin sistema saude ws

# requisitos de funcionaidade

# bosin sistema saude ws

# requisitos de funcionaidade

- [x]  Deve ser possivel cadastrar um medico;
- [x]  deve ser possivel listar os medicos cadastrados;
- [x]  deve ser possivel atualizar um medico por id;
- [x]  deve ser possivel desativar um medico do sistema;
- [x]  deve ser possivel cadastrar um paciente;
- [x]  deve ser possivel listar os pacientes cadastrados;
- [x]  deve ser possivel atualizar um paciente;
- [x]  deve ser possivel desativar um paciente do sistema;
- [ ]  deve ser possivel agendar uma consulta;
- [ ]  deve ser possivel cancelar uma consulta;

# regras de negocio

- [x]  a listagem de médicos devem ser ordenada por ordem crescente pelo nome do medico;
- [x]  não é permitido alterar o e-mail, crm e a especialidade do medico;
- [x]  não é permitido alterar o e-mail e o cpf do paciente;
- [x]  a listagem de paciente devem ser ordenada por ordem crescente pelo nome do paciente;
- [x]  As consultas tem duração fixa de 1 hora;
- [x]  As consultas devem ser agendadas com antecedência mínima de 30 minutos;
- [x]  Não permitir o agendamento de consultas com pacientes inativos no sistema;
- [x]  Não permitir o agendamento de consultas com médicos inativos no sistema;
- [x]  Não permitir o agendamento de mais de uma consulta no mesmo dia para um mesmo paciente;
- [x]  Não permitir o agendamento de uma consulta com um médico que já possui outra consulta agendada na mesma data/hora;
- [x]  A escolha do médico é opcional, sendo que nesse caso o sistema deve escolher aleatoriamente algum médico disponível na data/hora preenchida.
- [x]  O horário de funcionamento da clínica é de segunda a sábado, das 07:00 às 19:00;
- [x]  É obrigatório informar o motivo do cancelamento da consulta, dentre as opções: paciente desistiu, médico cancelou ou outros;
- [x]  Uma consulta somente poderá ser cancelada com antecedência mínima de 24 horas;
- [x]  exclusão de dados: não deve apagar os dados, mas torná-lo inativo;
- [x]  no cadastro de médico/paciente: todas informações deve ter preenchimento obrigatório, exceto número e complemento de endereço;

# requisitos não funcionais

- [x]  deve ser ultilizado uma aplicação padrão jaxws;
- [x]  deve ser persistido os dados em um banco de dados postgres;

