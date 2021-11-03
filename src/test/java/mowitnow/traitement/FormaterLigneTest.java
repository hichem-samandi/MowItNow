package mowitnow.traitement;
import static org.fest.assertions.Assertions.assertThat;
import mowitnow.entites.Coordonnees;
import mowitnow.entites.Params.InstructionTondeuse;
import mowitnow.entites.Params.Orientation;
import mowitnow.entites.Pelouse;

import org.junit.Test;
public class FormaterLigneTest {

	@Test
	public void formater_ligne_tondeuse() {
		assertThat(FormaterLigne.formaterLigneTondeuse("10 15 N").getCoordonneesTondeuse()).isEqualTo(new Coordonnees(10, 15));
		assertThat(FormaterLigne.formaterLigneTondeuse("10 15 N").getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void formater_ligne_pelouse() {
		assertThat(FormaterLigne.formaterLignePelouse("10 15")).isEqualTo(new Pelouse(new Coordonnees(10, 15)));
	}

	@Test
	public void formater_ligne_instruction() {
		assertThat(FormaterLigne.formaterLigneInstruction("DGAD")).hasSize(4)
				.contains(InstructionTondeuse.DROITE)
				.contains(InstructionTondeuse.GAUCHE)
				.contains(InstructionTondeuse.AVANCER);
	}

	@Test
	public void recuperer_orientation() {
		assertThat(FormaterLigne.getOrientation('E')).isEqualTo(Orientation.EAST);
		assertThat(FormaterLigne.getOrientation('N')).isEqualTo(Orientation.NORTH);
		assertThat(FormaterLigne.getOrientation('S')).isEqualTo(Orientation.SOUTH);
		assertThat(FormaterLigne.getOrientation('W')).isEqualTo(Orientation.WEST);
		assertThat(FormaterLigne.getOrientation('a')).isNull();
	}

	@Test
	public void testGetInstruction() {
		assertThat(FormaterLigne.getInstruction('A')).isEqualTo(InstructionTondeuse.AVANCER);
		assertThat(FormaterLigne.getInstruction('D')).isEqualTo(InstructionTondeuse.DROITE);
		assertThat(FormaterLigne.getInstruction('G')).isEqualTo(InstructionTondeuse.GAUCHE);
		assertThat(FormaterLigne.getInstruction(' ')).isNull();
	}

}
