package mdp2026.pokedex.service;

/**
 * Record utile a CommandAction come tipo di ritorno
 */
public record CommandResult(String[] output, int state) { }
