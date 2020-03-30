import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContainerPetshops containerPetshops = new ContainerPetshops();

        Petshop meuCaninoFeliz = new Petshop(
                "Meu Canino Feliz",
                2000,
                20.00,
                40.00,
                1.2
        );


        Petshop vaiRex = new Petshop(
                "Vai Rex",
                1700,
                15.00,
                50.00,
                20,
                55
        );

        Petshop chowChawgas = new Petshop(
                "ChowCawgas",
                800,
                30.00,
                45.00,
                30.00,
                45.00
        );

        containerPetshops.getContainerPetshops().add(meuCaninoFeliz);

        containerPetshops.getContainerPetshops().add(vaiRex);

        containerPetshops.getContainerPetshops().add(chowChawgas);

        System.out.println("Digite a entrada, ela é composta pela data, " +
                "número de cães pequenos e números de cães grandes. \nPor exemplo: 27/07/2019 5 5."
        );

        Scanner read = new Scanner(System.in);

        String data = read.next();

        String quantidadeCaesPequenos = read.next();

        String quantidadeCaesGrandes = read.next();

        while (!containerPetshops.validaData(data)) {

            System.out.println(
                    "O formato informado da data está incorreto. O formato deve ser dd/MM/yyyy, por exemplo:" +
                    " 27/07/2019. \nInsira novamente a data:"
            );

            data = read.next();
        }

        while (!containerPetshops.validaNumero(quantidadeCaesPequenos)) {
            System.out.println(
                    "O formato informado para quantidade de cães pequenos está incorreto." +
                            " O número deve ser um inteiro, por exemplo:" +
                            " 5. \nInsira novamente a quantidade de cães pequenos:"
            );
            quantidadeCaesPequenos = read.next();
        }

        while (!containerPetshops.validaNumero(quantidadeCaesGrandes)) {
            System.out.println(
                    "O formato informado para quantidade de cães grandes está incorreto." +
                            " O número deve ser um inteiro, por exemplo:" +
                            " 5. \nInsira novamente a quantidade de cães grandes:"
            );
            quantidadeCaesGrandes = read.next();
        }

        Petshop melhor = containerPetshops.melhorPetshop(
                data,
                Integer.parseInt(quantidadeCaesGrandes),
                Integer.parseInt(quantidadeCaesPequenos)
        );

        System.out.println(
                "O melhor Petshop para levar os cães é: "
                        + melhor.getNome() + "\nO preço total dos banhos é: " + melhor.getPrecoTotal() + " reais"
        );
    }


}
