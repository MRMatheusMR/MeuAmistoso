package meuamistoso.dao.test;

import meuamistoso.dao.Banco;
import meuamistoso.dao.UsuarioDAO;
import meuamistoso.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ellen
 */
public class UsuarioDAOTeste {

    public UsuarioDAOTeste() {
    }

    @BeforeAll
    public static void setUpClass() {
        Banco.inicia();
    }

    @AfterAll
    public static void tearDownClass() {
        Banco.usuario.clear();
        Banco.jogos.clear();
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario(6, "Novo Usuário", "novo@anhembi.br", "senha123");

        usuarioDAO.insert(usuario);

        // Verifica se o usuário foi inserido corretamente
        assertEquals(6, Banco.usuario.size());
        assertTrue(Banco.usuario.contains(usuario));
    }
    
     @Test
    public void testUpdate() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario(2, "Henrique Alterado", "henrique@anhembi.br", "novasenha");

        boolean updated = usuarioDAO.update(usuario);

        // Verifica se o usuário foi atualizado corretamente
        assertTrue(updated);
        assertEquals("Henrique Alterado", Banco.usuario.get(1).getNome());
        assertEquals("novasenha", Banco.usuario.get(1).getSenha());
    }

    @Test
    public void testDelete() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario(3, "Felipe", "felipe@anhembi.br", "12345678");

        boolean deleted = usuarioDAO.delete(usuario);

        // Verifica se o usuário foi removido corretamente
        assertTrue(deleted);
        assertEquals(4, Banco.usuario.size());
        assertFalse(Banco.usuario.contains(usuario));
    }

    @Test
    public void testSelectAll() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Obtém a lista de usuários do Banco
        assertEquals(5, usuarioDAO.selectAll().size());
    }

    @Test
    public void testSelectPorEmailESenha() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("henrique@anhembi.br", "12345678");

        Usuario foundUser = usuarioDAO.selectPorEmailESenha(usuario);

        // Verifica se o usuário foi encontrado corretamente
        assertNotNull(foundUser);
        assertEquals("Henrique", foundUser.getNome());
    }

    @Test
    public void testaLogin(){
        System.out.println("oi");
}
}
