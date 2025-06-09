package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.dtos.DisciplinaDTO;
import com.iefp.controle_escolar.dtos.TurmaDTO;
import com.iefp.controle_escolar.dtos.TurmaDisciplinaDTO;
import com.iefp.controle_escolar.dtos.UserDTO;
import com.iefp.controle_escolar.entities.TurmaDisciplinaEntity;
import com.iefp.controle_escolar.mappers.TurmaDisciplinaMapper;
import com.iefp.controle_escolar.repositories.TurmaDisciplinaRepository;
import com.iefp.controle_escolar.services.DisciplinaService;
import com.iefp.controle_escolar.services.TurmaDisciplinaService;
import com.iefp.controle_escolar.services.TurmaService;
import com.iefp.controle_escolar.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaDisciplinaServiceImpl implements TurmaDisciplinaService {

    private final TurmaDisciplinaRepository repository;
    private final TurmaDisciplinaMapper mapper;
    private final TurmaService turmaService;
    private final DisciplinaService disciplinaService;
    private final UsuarioService usuarioService;

    @Override
    public List<TurmaDisciplinaDTO> listarTodos() {

        List<TurmaDisciplinaEntity> disciplinas = repository.findAll();
        List<TurmaDisciplinaDTO> TurmaDisciplinas = mapper.toDTOList(disciplinas);

        TurmaDisciplinas.forEach(t -> {
            TurmaDTO turma = turmaService.buscarPorId(t.getTurmaId());
            t.setTurmaNome(turma.getNome());

            DisciplinaDTO disciplina = disciplinaService.buscarPorId(t.getDisciplinaId());
            t.setDisciplinaNome(disciplina.getNome());

            UserDTO user = usuarioService.buscarPorId(t.getProfessorId());
            t.setProfessorNome(user.getNome());
        });

        return TurmaDisciplinas;
    }

    @Override
    public void salvar(TurmaDisciplinaDTO dto) {

        TurmaDisciplinaEntity turma = mapper.toEntity(dto);
        repository.save(turma);
    }

    @Override
    public void excluirById(Long id) {
        repository.deleteById(id);
    }
}
