from odoo import models, fields
from odoo.exceptions import UserError


class Equipo (models.Model):
    _name = 'bytemadrid.equipo'
    _description = 'Equipo Informático'

    name = fields.Char(
        string="Nombre del equipo",
        required=True
    )

    fabricante = fields.Char(
        string="Nombre del fabricante",
        required=True
    )

    modelo = fields.Char(
        string="Nombre del modelo"
    )

    numero_serie = fields.Char(
        string="Número de serie"
    )

    precio = fields.Float(
        string="Precio"
    )

    activo = fields.Boolean(
        string="Activo",
        default=True
    )

    proveedor_id = fields.Many2one(
    'res.partner',
    string='Proveedor',
    )

    responsable_id = fields.Many2one(
        'res.users',
        string='Responsable',
        domain=[('share', '=', False)],
    )

    estado = fields.Selection(
    selection=[
        ('disponible', 'Disponible'),
        ('asignado', 'Asignado'),
        ('averiado', 'Averiado'),
        ('baja', 'Baja'),
    ],
    string='Estado operativo',
    required=True,
    default='disponible',
    )

    def action_asignar(self):
        for equipo in self:
            if not equipo.responsable_id:
                raise UserError(
                    'Selecciona un responsable antes de asignar el equipo.'
                )
            if equipo.estado != 'disponible':
                raise UserError(
                    'Solo se puede asignar un equipo disponible.'
                )
            equipo.write({'estado': 'asignado'})
        return True
    
def action_liberar(self):
    for equipo in self:
        if equipo.estado != 'asignado':
            raise UserError(
                'Solo se puede liberar un equipo asignado.'
            )
        equipo.write({
            'estado': 'disponible',
            'responsable_id': False,
        })
    return True


def action_marcar_averiado(self):
    for equipo in self:
        if equipo.estado not in ('disponible', 'asignado'):
            raise UserError(
                'Solo se puede marcar como averiado un equipo '
                'disponible o asignado.'
            )
        equipo.write({'estado': 'averiado'})
    return True


def action_reparar(self):
    for equipo in self:
        if equipo.estado != 'averiado':
            raise UserError(
                'Solo se puede reparar un equipo averiado.'
            )
        equipo.write({
            'estado': 'disponible',
            'responsable_id': False,
        })
    return True


def action_dar_baja(self):
    for equipo in self:
        if equipo.estado == 'baja':
            raise UserError(
                'El equipo ya está dado de baja.'
            )
        equipo.write({
            'estado': 'baja',
            'responsable_id': False,
        })
    return True


def action_reactivar(self):
    for equipo in self:
        if equipo.estado != 'baja':
            raise UserError(
                'Solo se puede reactivar un equipo dado de baja.'
            )
        equipo.write({'estado': 'disponible'})
    return True
