package com.example.entity.effect;

/**
 * Représente un effet permettant d'afficher un message dans la console
 */
public class MessageEffect implements Effect
{
    /**
     * Le message à afficher
     */
    private String message;

    /**
     * Crée un nouvel effet
     * @param message Le message à afficher
     */
    public MessageEffect(String message)
    {
        this.message = message;        
    }

    /**
     * Déclenche l'effet
     */
    public void trigger()
    {
        // Affiche le message dans la console
        System.out.println(message);
    }
}
